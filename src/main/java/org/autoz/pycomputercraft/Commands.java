package org.autoz.pycomputercraft;

import com.mojang.brigadier.arguments.StringArgumentType;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.text.Text;
import org.python.util.PythonInterpreter;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class Commands {

    private static final Map<String, PythonInterpreter> interpreters = new HashMap<>();
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream printStream = new PrintStream(outputStream);




    public void registercommand() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(literal("py")
                .then(literal("run")
                    .then(argument("name", StringArgumentType.string())
                        .then(argument("command", StringArgumentType.string())
                            .executes(context -> {
                                String name = StringArgumentType.getString(context, "name");
                                String command = StringArgumentType.getString(context, "command");

                                PythonInterpreter interpreter = interpreters.get(name);
                                if (interpreter != null) {
                                    try {
                                        PrintStream originalOut = System.out;
                                        // Redirect System.out to our custom PrintStream
                                        System.setOut(printStream);

                                        // Set the output stream of PythonInterpreter
                                        interpreter.setOut(printStream);

                                        interpreter.exec(command);

                                        // Reset System.out to the original
                                        System.setOut(originalOut);

                                        // Get the output from the ByteArrayOutputStream
                                        String output = outputStream.toString();
                                        // Clear the stream for future use
                                        outputStream.reset();
                                        // Send the output to the chat
                                        context.getSource().sendFeedback(() -> Text.literal(output), false);
                                    } catch (Exception e) {
                                        context.getSource().sendFeedback(() -> Text.literal("Error executing command: " + e.getMessage()), false);
                                    }

                                } else {
                                    context.getSource().sendFeedback(() -> Text.literal("Python Interpreter with name " + name + " does not exist"), false);
                                }
                                return 1;
                            }))))
                .then(literal("new")
                    .then(argument("name", StringArgumentType.string())
                        .executes(context -> {
                            String name = StringArgumentType.getString(context, "name");
                            if (!interpreters.containsKey(name)) {
                                PythonInterpreter interpreter = new PythonInterpreter();
                                interpreters.put(name, interpreter);
                                context.getSource().sendFeedback(() -> Text.literal("Python ComputerCraft New " + name), false);
                            } else {
                                context.getSource().sendFeedback(() -> Text.literal("Python Interpreter with name " + name + " already exists"), false);
                            }
                            return 1;
                        })))
                )
        );
    }


    public static void init() {
        new Commands().registercommand();
    }
}
