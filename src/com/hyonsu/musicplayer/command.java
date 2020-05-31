package com.hyonsu.musicplayer;

import com.xxmicloxx.NoteBlockAPI.model.Song;
import com.xxmicloxx.NoteBlockAPI.songplayer.RadioSongPlayer;
import com.xxmicloxx.NoteBlockAPI.utils.NBSDecoder;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

class play implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        Player player = (Player) sender;
        if(!player.isOp()) {
            player.sendMessage("§c권한이 없습니다. OP가 필요합니다.");
            return false;
        }

        // 값 입력 체크
        if(args.length == 0) {
            player.sendMessage("플레이할 NBS 파일을 입력해야 합니다!\n사용법 : /play <파일명> : 플러그인에 들어있는 <파일명>을 재생합니다.");
        }

        // 음악 등록
        InputStream in;
        BufferedReader reader;
        Song song;

        in = getClass().getResourceAsStream("/music/" + args[0]);
        reader = new BufferedReader(new InputStreamReader(in));
        song = NBSDecoder.parse(in);
        RadioSongPlayer song_megalovania = new RadioSongPlayer(song);

        for(Player all : Bukkit.getServer().getOnlinePlayers()) {
            song_megalovania.addPlayer(all);
        }
        song_megalovania.setPlaying(true);
        player.sendMessage("§a음악을 재생합니다.");
        return false;
    }
}