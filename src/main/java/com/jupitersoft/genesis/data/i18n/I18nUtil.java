package com.jupitersoft.genesis.data.i18n;

import com.crypticmushroom.minecraft.registry.data.registry.LocalizedNameRegistry;
import com.jupitersoft.genesis.GCMGalosphereInfo;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraftforge.common.ForgeI18n;
import org.jetbrains.annotations.Nullable;

public class I18nUtil {
    public static MutableComponent component(String key, String translation, @Nullable Object... args) {
        LocalizedNameRegistry.OTHER.registerReplace(GCMGalosphereInfo.MOD_ID, key, translation);
        return args != null && args.length > 0 ? Component.translatable(key, args) : Component.translatable(key);
    }

    public static String stringKey(String key, String translation) {
        LocalizedNameRegistry.OTHER.registerReplace(GCMGalosphereInfo.MOD_ID, key, translation);
        return key;
    }

    public static String stringTranslated(String key, String translation, @Nullable Object... args) {
        LocalizedNameRegistry.OTHER.registerReplace(GCMGalosphereInfo.MOD_ID, key, translation);
        return ForgeI18n.parseFormat(key, args);
    }
}
