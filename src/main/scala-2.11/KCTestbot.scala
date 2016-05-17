import com.sun.deploy.net.URLEncoder
import info.mukel.telegram.bots.v2._

//import scala.swing._

import scala.xml.XML
/**
  * Created by KC on 4/25/2016.
  */

object Time {
  private val form = new java.text.SimpleDateFormat("HH:mm:ss")
  def current = form.format(java.util.Calendar.getInstance().getTime)
}

object Timer {
  def apply(interval: Int, repeats: Boolean = true)(op: => Unit) {
    val timeOut = new javax.swing.AbstractAction() {
      def actionPerformed(e : java.awt.event.ActionEvent) = op
    }
    val t = new javax.swing.Timer(interval, timeOut)
    t.setRepeats(repeats)
    t.start()
  }
}

object KCTestbot extends TelegramBot with Polling with Commands {
  import info.mukel.telegram.bots.v2.methods.SendMessage
  def token = "151062463:AAHm_0Ty8xqMBCgqdHM-Z_qgnS13qFk1KRk"

  def getXML(link: String) {
    val xml = XML.load(link)
    return xml
  }

  on("/echo") { implicit message => args =>
    reply(Time.current mkString)
    reply(args mkString)
  }

//  on("/kc") { implicit message => args =>
//    api.request(SendMessage(message.sender, args mkString))
//  }



  def main(args: Array[String]) {
    println("Test")
    println(Time.current)
    KCTestbot.run()
  }
}