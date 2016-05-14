package events.dispatcher

import events.IEvent
import events.sources.ISource
import rx._

/**
  * Created by morphing on 14.05.16.
  */
class Dispatcher {
  lazy val sources = Var[List[ISource]](List.empty)

  lazy val sinks: Var[List[ISource]] = Var(List.empty)
}
