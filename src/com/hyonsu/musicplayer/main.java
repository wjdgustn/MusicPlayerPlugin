package com.hyonsu.musicplayer;

import com.xxmicloxx.NoteBlockAPI.SongPlayer;
import com.xxmicloxx.NoteBlockAPI.model.Song;
import com.xxmicloxx.NoteBlockAPI.songplayer.RadioSongPlayer;
import com.xxmicloxx.NoteBlockAPI.utils.NBSDecoder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class main extends JavaPlugin {
    @Override
    public void onEnable() {
        // 의존성 확인
        boolean NoteBlockApi = true;
        if(!Bukkit.getPluginManager().isPluginEnabled("NoteBlockAPI")) {
            Bukkit.getLogger().info("§cNoteBlockAPI를 찾지 못했습니다.");
        }

        // 커맨드 등록
        getCommand("play").setExecutor(new play());

        // 활성화 알림
        Bukkit.getLogger().info("§a[HYONSU_MusicPlayerPlugin] 플러그인이 활성화 되었습니다.");
    }

    @Override
    public void onDisable() {
        // 비활성화 알림
        Bukkit.getLogger().info("§a[HYONSI_MusicPlayerPlugin] 플러그인이 비활성화 되었습니다.");
    }
}
