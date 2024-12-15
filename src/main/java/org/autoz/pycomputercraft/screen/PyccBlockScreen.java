package org.autoz.pycomputercraft.screen;


import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public class PyccBlockScreen extends HandledScreens<PyccBlockScreenHandler> {
        private TextFieldWidget inputField;

            public CustomScreen(PyccBlockScreenHandler handler, PlayerInventory inventory, Text title) {
                        super(handler, inventory, title);
                            }

                                @Override
        protected void init() {
                        super.init();
                                inputField = new TextFieldWidget(textRenderer, this.x + 10, this.y + 10, 200, 20, Text.literal(""));
                                        inputField.setEditable(true);
                                                addDrawableChild(inputField);
                                                    }

                                                        @Override
        public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
                        super.render(matrices, mouseX, mouseY, delta);
                                inputField.render(matrices, mouseX, mouseY, delta);
                                    }

                                        @Override
        public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
                        if (inputField.keyPressed(keyCode, scanCode, modifiers) || inputField.isActive()) {
                                        return true;
                                                }
                                return super.keyPressed(keyCode, scanCode, modifiers);
                            }
                            }

                        }
            }
}