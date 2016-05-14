package events.sources.keyboard

import java.awt.event.KeyEvent

import events._
import events.sources.ISource
import rx._
import org.scalajs.dom
import org.scalajs.dom.raw._

sealed class KeyboardEvent extends IEventKind

object KeyPress extends KeyboardEvent
object KeyDown extends KeyboardEvent
object KeyUp extends KeyboardEvent

case class Event(source: ISource, keyCode: Int, kind: KeyboardEvent)
  extends IEvent


object Keyboard
  extends ISource
  with IProducer
{
  val producing = Set(KeyEvent)
  lazy val source = {
    val event = Var[Event](null)
    dom.document.addEventListener(
      "keypress",
      (nativeEvent: dom.KeyboardEvent) => {
        event() = new Event(this, nativeEvent.keyCode, KeyPress)
      }, useCapture = false)
    dom.document.addEventListener(
      "keydown",
      (nativeEvent: dom.KeyboardEvent) => {
        event() = new Event(this, nativeEvent.keyCode, KeyDown)
      }, useCapture = false)
    dom.document.addEventListener(
      "keyup",
      (nativeEvent: dom.KeyboardEvent) => {
        event() = new Event(this, nativeEvent.keyCode, KeyUp)
      }, useCapture = false)
    event
  }
}
