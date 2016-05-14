package components

import events.IEvent
import events.dispatcher._
import primitives.IPrimitive
import rx._
import sun.rmi.server.Dispatcher

/**
  * Created by morphing on 14.05.16.
  */
trait IComponent {
  def listener(dispatcher: Dispatcher): Rx[IEvent]
  def root: Var[IPrimitive]
}
