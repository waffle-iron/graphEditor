package primitives

import events.IEvent
import org.scalajs.dom.raw.HTMLElement
import rx.{Obs, Var}

/**
  * Created by morphing on 14.05.16.
  */
trait IPrimitive {
  def root: Var[HTMLElement]
  def listener: Obs
}
