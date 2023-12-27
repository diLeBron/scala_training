package SimpleREST

import cats.effect.{ExitCode, IO, IOApp}
import org.http4s.HttpRoutes
//import org.http4s.dsl.io.{GET, Ok, Root}
import org.http4s.dsl.io._
import org.http4s.blaze.server.BlazeServerBuilder
import scala.concurrent.ExecutionContext.global

object ColleagueQueryParamMatcher extends QueryParamDecoderMatcher[String]("colleague")

object Server extends IOApp {
  val helloWorldService = HttpRoutes.of[IO] {
    case GET -> Root / "hello" / name :? ColleagueQueryParamMatcher(colleague) => Ok(s"Привет, ${name.capitalize} и ${colleague.capitalize}!")
    case GET -> Root / "hello" / name => Ok(s"Hello, ${name.capitalize}!")
  }.orNotFound

  def run(args: List[String]): IO[ExitCode] =
    BlazeServerBuilder[IO](global)
      .bindHttp(8080, "localhost")
      .withHttpApp(helloWorldService)
      .serve
      .compile
      .drain
      .as(ExitCode.Success)

}
