package events

import rx._

class Connection[Producer, Consumer](
      producer: Producer,
      consumer: Consumer,
      allowedEvents: Set[IEventKind])

/**
  * Created by morphing on 14.05.16.
  */
trait IStream[Producer, Consumer] {
  def passingEvents: Var[Set[IEventKind]]

  def connections: Var[List[Connection[Producer, Consumer]]]
}
