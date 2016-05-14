package components.menu

import components.IComponent
import events.IEvent
import events.dispatcher.Dispatcher
import primitives.IPrimitive
import rx._

/**
  * Created by morphing on 14.05.16.
  */
abstract class Menu extends IComponent {
  def listener(dispatcher: Dispatcher): Rx[IEvent] = {
    null
  }
  def root: Var[IPrimitive]
  def listen(dispatcher: Dispatcher): Var[IEvent]
}
