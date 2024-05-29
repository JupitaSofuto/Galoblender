package com.jupitersoft.genesis.galoblender.common;

import net.minecraftforge.common.ForgeConfigSpec;

public class GaloblenderConfig {
    public static final ForgeConfigSpec COMMON_SPEC;

    public static final Common COMMON;

    static {
        var commonSpecBuilder = new ForgeConfigSpec.Builder();
        COMMON = new Common(commonSpecBuilder);
        COMMON_SPEC = commonSpecBuilder.build();
    }

    public static class Common {
        public final ForgeConfigSpec.IntValue galosphereCavesWeight;

        private Common(ForgeConfigSpec.Builder builder) {
            this.galosphereCavesWeight =
                builder.translation("galoblender.config.common.galosphereCavesWeight")
                    .comment("The weighting of Galosphere biome region in the overworld (for reference, the overworld biomes' default is 10).")
                    .worldRestart()
                    .defineInRange("galosphereCavesWeight", 1, 0, Integer.MAX_VALUE);
        }
    }
}
