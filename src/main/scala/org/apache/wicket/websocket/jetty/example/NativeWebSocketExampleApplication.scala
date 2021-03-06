package org.apache.wicket.websocket.jetty.example

import org.apache.wicket.protocol.http.WebApplication

object NativeWebSocketExampleApplication
{
	def get = WebApplication.get().asInstanceOf[NativeWebSocketExampleApplication]
}

/**
 * The application class that setups the event system that pushes messages
  * to the connected clients
 */
class NativeWebSocketExampleApplication extends WebApplication
{
  var eventSystem : EventSystem = _

  override def getHomePage = classOf[WebSocketDemo]

  override def init() {
    super.init()

    eventSystem = new EventSystem(this)
  }

  override def onDestroy() {
    eventSystem.shutdown()
    super.onDestroy()
  }

  def getEventSystem = eventSystem
}



