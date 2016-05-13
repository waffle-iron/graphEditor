package events.sources.keyboard

import events.IEvent
import rx._
import org.scalajs.dom
import org.scalajs.dom.raw._

sealed class Kind

object KeyPress extends Kind
object KeyDown extends Kind
object KeyUp extends Kind

case class Event(keyCode: Int, kind: Kind) extends IEvent

object Keyboard {
  lazy val source = {
    val event = Var[Event](null)
    dom.document.addEventListener(
      "keypress",
      (nativeEvent: KeyboardEvent) => {
        event() = new Event(nativeEvent.keyCode, KeyPress)
      }, useCapture = false)
    event
  }
}
