import akka.actor._

object ClientManager extends App  {
  val system = ActorSystem("CollectorSystem")
  val remoteActor = system.actorOf(Props[ClientManagerActor], name = "ClientManagerActor")
  remoteActor ! Message("The ClientManagerActor is alive")
}

class ClientManagerActor extends Actor {
  def receive = {
    case Message(msg) =>
      println(s"ClientManagerActor received message '$msg'")
      sender ! Message("Hello from the ClientManagerActor")
    case _ =>
      println("ClientManagerActor got something unexpected.")

  }
}
