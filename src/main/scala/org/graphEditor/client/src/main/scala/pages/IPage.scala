package pages

import layouts.ILayout
import org.scalajs.dom.raw.HTMLElement
import rx.Var

/**
  * Created by morphing on 14.05.16.
  */
trait IPage {
  def root: Var[ILayout]
  val route: Var[Route]
}
