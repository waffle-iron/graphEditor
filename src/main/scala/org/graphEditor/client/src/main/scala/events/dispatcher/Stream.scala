package events.dispatcher

import events.{IConsumer, IEventKind, IProducer, IStream}
import rx.Var

/**
  * Created by morphing on 14.05.16.
  */
class Stream
  extends IStream[IProducer, IConsumer] {
  lazy val passingEvents = Var(Set.empty)
  lazy val connections = Var(List.empty)
}
