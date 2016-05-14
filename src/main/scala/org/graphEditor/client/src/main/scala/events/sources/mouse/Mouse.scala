package events.sources.mouse

import events.IEvent
import events.sources.ISource
import rx._
import org.scalajs.dom
import org.scalajs.dom.raw._

case class Position(top: Double, left: Double)

sealed class Kind

object Move extends Kind
object Click extends Kind
object ButtonUp extends Kind
object ButtonDown extends Kind

case class Event(source: ISource, position: Position, kind: Kind) extends IEvent

object Mouse extends  ISource {
  lazy val source = {
    val event = Var[Event](null)
    dom.document.addEventListener(
      "mousemove",
      (nativeEvent: MouseEvent) => {
        event() = new Event(
          this,
          Position(nativeEvent.pageX, nativeEvent.pageY),
          Move
        )
      }, useCapture = false)

      dom.document.addEventListener(
        "mouseup",
        (nativeEvent: MouseEvent) => {
          event() = new Event(
            this,
            Position(nativeEvent.pageX, nativeEvent.pageY),
            ButtonUp
          )
        }, useCapture = false)

        dom.document.addEventListener(
          "mousedown",
          (nativeEvent: MouseEvent) => {
            event() = new Event(
              this,
              Position(nativeEvent.pageX, nativeEvent.pageY),
              ButtonDown
            )
          }, useCapture = false)

          dom.document.addEventListener(
            "click",
            (nativeEvent: MouseEvent) => {
              event() = new Event(
                this,
                Position(nativeEvent.pageX, nativeEvent.pageY),
                Click
              )
            }, useCapture = false)
    event
  }
}
