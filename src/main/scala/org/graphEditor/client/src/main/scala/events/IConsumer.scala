package events

/**
  * Created by morphing on 14.05.16.
  */
trait IConsumer {
  def consuming: Set[IEventKind]
}
