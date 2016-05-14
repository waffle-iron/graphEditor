package events

/**
  * Created by morphing on 14.05.16.
  */
trait IProducer {
  def producing: Set[IEventKind]
}
