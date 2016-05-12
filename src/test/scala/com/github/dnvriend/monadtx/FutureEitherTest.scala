/*
 * Copyright 2016 Dennis Vriend
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.dnvriend.monadtx

import com.github.dnvriend.TestSpec
import io.github.hamsters.FutureEither
import io.github.hamsters.MonadTransformers._
import io.github.hamsters.Validation._

import scala.concurrent.Future

/**
  * Please read: http://loicdescotte.github.io/posts/scala-compose-option-future/
  */
class FutureEitherTest extends TestSpec {
  it should "compose" in {
    def fea: Future[Either[String, Int]] = Future(OK(1))
    def feb(a: Int): Future[Either[String, Int]] = Future(OK(a + 2))

    val composedAB: Future[Either[String, Int]] = for {
      a ← FutureEither(fea)
      ab ← FutureEither(feb(a))
    } yield ab

    composedAB.futureValue should matchPattern {
      case OK(3) ⇒
    }
  }
}
