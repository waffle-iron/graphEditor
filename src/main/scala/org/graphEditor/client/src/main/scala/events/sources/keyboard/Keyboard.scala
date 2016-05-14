package events.sources.keyboard

import events.IEvent
import events.sources.ISource
import rx._
import org.scalajs.dom
import org.scalajs.dom.raw._

sealed class Kind

object KeyPress extends Kind
object KeyDown extends Kind
object KeyUp extends Kind

case class Event(source: ISource, keyCode: Int, kind: Kind) extends IEvent

object Keyboard extends ISource {
  lazy val source = {
    val event = Var[Event](null)
    dom.document.addEventListener(
      "keypress",
      (nativeEvent: KeyboardEvent) => {
        event() = new Event(this, nativeEvent.keyCode, KeyPress)
      }, useCapture = false)
    dom.document.addEventListener(
      "keydown",
      (nativeEvent: KeyboardEvent) => {
        event() = new Event(this, nativeEvent.keyCode, KeyDown)
      }, useCapture = false)
    dom.document.addEventListener(
      "keyup",
      (nativeEvent: KeyboardEvent) => {
        event() = new Event(this, nativeEvent.keyCode, KeyUp)
      }, useCapture = false)
    event
  }
}
