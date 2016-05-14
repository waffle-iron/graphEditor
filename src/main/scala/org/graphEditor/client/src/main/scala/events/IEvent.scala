package events

import events.sources.ISource

/**
  * Created by morphing on 14.05.16.
  */
trait IEvent {
  val source: ISource
  val kind: IEventKind
}
