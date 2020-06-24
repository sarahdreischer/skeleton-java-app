package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QueryProcessorTest {

  QueryProcessor queryProcessor = new QueryProcessor();

  @Test
  public void knowsWhoWroteRomeoAndJuliet() throws Exception {
    assertThat(queryProcessor.process("Who wrote Romeo And Juliet"), containsString("Shakespeare"));
  }

  @Test
  public void returnsQueryId() {
    assertThat(queryProcessor.process("what is your name"), containsString("Sarah D"));
  }

  @Test
  public void returnsGreatestNumber() {
    assertThat(queryProcessor.process("which of the following numbers is the largest: 2036, 20100, 20585"), containsString("20585"));
  }

  @Test
  public void canReturnAddition() {
    assertThat(queryProcessor.process("what is 20 plus 2015"), containsString("2035"));
  }


  @Test
  public void isNotCaseSensitive() throws Exception {
    assertThat(queryProcessor.process("who wrote romeo and juliet"), containsString("Shakespeare"));
  }

  @Test
  public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
    assertThat(queryProcessor.process("test"), is(""));
  }
}
