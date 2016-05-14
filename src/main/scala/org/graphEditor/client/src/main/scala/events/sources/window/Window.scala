package events.sources.window

import java.awt.event.WindowEvent

import events.{IEvent, IEventKind, IProducer}
import events.sources.ISource
import org.scalajs.dom
import org.scalajs.dom.raw.MouseEvent
import rx.Var


sealed class WindowEvent extends IEventKind

object HashChanged extends WindowEvent

case class Event(source: ISource, kind: WindowEvent) extends IEvent

/**
  * Created by morphing on 14.05.16.
  */
class Window
  extends ISource
  with IProducer
{
  lazy val producing = Set(WindowEvent)
  lazy val source = {
    val event = Var[Event](null)
    dom.document.addEventListener(
      "load",
      (nativeEvent: dom.HashChangeEvent) => {
        event() = new Event(source, HashChanged)
      }, useCapture = false)
    event
  }
}
