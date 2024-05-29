package com.jupitersoft.genesis.common.config;

import com.jupitersoft.genesis.data.i18n.I18nUtil;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;

public class GenesisConfig {
    public static final ForgeConfigSpec CLIENT_SPEC, COMMON_SPEC, SERVER_SPEC;

    public static final Client CLIENT;
    public static final Common COMMON;
    public static final Server SERVER;

    static {
        var clientSpecBuilder = new ConfigSpecBuilder();
        CLIENT = new Client(clientSpecBuilder);
        CLIENT_SPEC = clientSpecBuilder.build();

        var commonSpecBuilder = new ConfigSpecBuilder();
        COMMON = new Common(commonSpecBuilder);
        COMMON_SPEC = commonSpecBuilder.build();

        var serverSpecBuilder = new ConfigSpecBuilder();
        SERVER = new Server(serverSpecBuilder);
        SERVER_SPEC = serverSpecBuilder.build();
    }

    public static class Client {
        private Client(ConfigSpecBuilder builder) { }
    }

    public static class Common {
        public final ForgeConfigSpec.IntValue galosphereCavesWeight;

        private Common(ConfigSpecBuilder builder) {
            this.galosphereCavesWeight =
                builder.comment(
                        "common.galosphereCavesWeight",
                        "Galosphere Caves Weight",
                        "The weighting of Galosphere biome region in the overworld (for reference, the overworld biomes' default is 10)."
                    )
                    .worldRestart()
                    .defineInRange("galosphereCavesWeight", 1, 0, Integer.MAX_VALUE);
        }
    }

    public static class Server {
        private Server(ConfigSpecBuilder builder) { }
    }

    private static class ConfigSpecBuilder extends ForgeConfigSpec.Builder {
        public ConfigSpecBuilder comment(String translationKey, String name, String comment) {
            var key = I18nUtil.stringKey("genesis.configgui." + translationKey, name);
            I18nUtil.stringKey(key + ".tooltip", comment);
            this.translation(key);
            return this.comment(comment);
        }

        @Override
        @Deprecated
        public ConfigSpecBuilder comment(String comment) {
            return (ConfigSpecBuilder) super.comment(comment);
        }

        @Override
        @Deprecated
        public ConfigSpecBuilder comment(String... comment) {
            return (ConfigSpecBuilder) super.comment(comment);
        }

        @Override
        @Deprecated
        public ConfigSpecBuilder translation(String translationKey) {
            return (ConfigSpecBuilder) super.translation(translationKey);
        }

        @Override
        public ConfigSpecBuilder worldRestart() {
            return (ConfigSpecBuilder) super.worldRestart();
        }

        @Override
        public ConfigSpecBuilder push(String path) {
            return (ConfigSpecBuilder) super.push(path);
        }

        @Override
        public ConfigSpecBuilder push(List<String> path) {
            return (ConfigSpecBuilder) super.push(path);
        }

        @Override
        public ConfigSpecBuilder pop() {
            return (ConfigSpecBuilder) super.pop();
        }

        @Override
        public ConfigSpecBuilder pop(int count) {
            return (ConfigSpecBuilder) super.pop(count);
        }
    }
}
