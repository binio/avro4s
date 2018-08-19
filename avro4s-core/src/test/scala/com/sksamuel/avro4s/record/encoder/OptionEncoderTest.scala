package com.sksamuel.avro4s.record.encoder

import com.sksamuel.avro4s.internal.{Encoder, InternalRecord, SchemaEncoder}
import org.scalatest.{Matchers, WordSpec}

class OptionEncoderTest extends WordSpec with Matchers {

  "Encoder" should {
    "support String options" in {
      case class Test(s: Option[String])
      val schema = SchemaEncoder[Test].encode()
      Encoder[Test].encode(Test(Option("qwe")), schema) shouldBe InternalRecord(schema, Vector("qwe"))
      Encoder[Test].encode(Test(None), schema) shouldBe InternalRecord(schema, Vector(null))
    }
    "support boolean options" in {
      case class Test(b: Option[Boolean])
      val schema = SchemaEncoder[Test].encode()
      Encoder[Test].encode(Test(Option(true)), schema) shouldBe InternalRecord(schema, Vector(true))
      Encoder[Test].encode(Test(None), schema) shouldBe InternalRecord(schema, Vector(null))
    }
  }
}
