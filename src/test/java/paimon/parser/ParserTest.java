package paimon.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import paimon.commands.CommandCreate;
import paimon.commands.CommandGoodbye;
import paimon.commands.CommandMark;
import paimon.items.Deadline;
import paimon.items.Event;
import paimon.items.Todo;

public class ParserTest {
    @Test
    public void testParse() {
        assertEquals(new CommandGoodbye(), Parser.parse("bye"));
        assertEquals(new CommandMark(0), Parser.parse("mark 1"));
        assertEquals(new CommandCreate(new Todo("read book")), Parser.parse("todo read book"));
        assertEquals(new CommandCreate(new Deadline("return book", "2/12/2019 1800")), Parser.parse("deadline return book /by 2/12/2019 1800"));
        assertEquals(new CommandCreate(new Event("project meeting", "2/12/2019 1800", "2/12/2022 1900")), Parser.parse("event project meeting /from 2/12/2019 1800 /to 2/12/2022 1900"));
    }
}
