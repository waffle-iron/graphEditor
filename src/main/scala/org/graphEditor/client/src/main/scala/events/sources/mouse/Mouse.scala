package events.sources.mouse

import events._
import events.sources.ISource
import rx._
import org.scalajs.dom
import org.scalajs.dom.raw._

case class Position(top: Double, left: Double)

sealed class MouseEvent extends IEventKind

object Move extends MouseEvent
object Click extends MouseEvent
object ButtonUp extends MouseEvent
object ButtonDown extends MouseEvent

case class Event(source: ISource, position: Position, kind: MouseEvent) extends IEvent

object Mouse extends  ISource {
  lazy val source = {
    val event = Var[Event](null)
    dom.document.addEventListener(
      "mousemove",
      (nativeEvent: dom.MouseEvent) => {
        event() = new Event(
          this,
          Position(nativeEvent.pageX, nativeEvent.pageY),
          Move
        )
      }, useCapture = false)

      dom.document.addEventListener(
        "mouseup",
        (nativeEvent: dom.MouseEvent) => {
          event() = new Event(
            this,
            Position(nativeEvent.pageX, nativeEvent.pageY),
            ButtonUp
          )
        }, useCapture = false)

        dom.document.addEventListener(
          "mousedown",
          (nativeEvent: dom.MouseEvent) => {
            event() = new Event(
              this,
              Position(nativeEvent.pageX, nativeEvent.pageY),
              ButtonDown
            )
          }, useCapture = false)

          dom.document.addEventListener(
            "click",
            (nativeEvent: dom.MouseEvent) => {
              event() = new Event(
                this,
                Position(nativeEvent.pageX, nativeEvent.pageY),
                Click
              )
            }, useCapture = false)
    event
  }
}
