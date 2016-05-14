package events.sources

import events.IEvent
import rx.Var

/**
  * Created by morphing on 14.05.16.
  */
trait ISource {
  def source: Var[IEvent]
}
