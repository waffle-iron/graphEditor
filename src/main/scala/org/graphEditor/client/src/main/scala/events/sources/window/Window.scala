package events.sources.window

import events.IEvent
import events.sources.ISource
import events.sources.mouse.Position
import org.scalajs.dom
import org.scalajs.dom.raw.MouseEvent
import rx.Var


sealed class Kind

object Loaded extends Kind

case class Event(source: ISource, kind: Kind) extends IEvent

/**
  * Created by morphing on 14.05.16.
  */
class Window extends ISource {
  lazy val source = {
    val event = Var[Event](null)
    dom.document.addEventListener(
      "load",
      (nativeEvent: MouseEvent) => {
        event() = new Event(source, Loaded)
      }, useCapture = false)
    event
  }
}
