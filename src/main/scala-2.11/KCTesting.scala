import scala.xml.XML

/**
  * Created by KC on 4/25/2016.
  */
object KCTesting {
  def getXML(link: String) {
    val xml = XML.load(link)
    return xml
  }
}