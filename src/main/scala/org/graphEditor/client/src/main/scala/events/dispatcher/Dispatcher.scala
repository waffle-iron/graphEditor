package events.dispatcher

import events.sources.ISource
import rx.Var

/**
  * Created by morphing on 14.05.16.
  */
class Dispatcher {
  lazy val sources: Var[List[ISource]] = Var(null)
}
