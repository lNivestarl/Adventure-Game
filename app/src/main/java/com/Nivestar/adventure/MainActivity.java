package com.Nivestar.adventure;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.content.DialogInterface;
import android.util.Log;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    String TAG = "ACTIVITY ONE";
    String name;
    int id_class;
    MediaPlayer music;
    private static Boolean enable_song = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        button_off();

    }
    public void start_game(){
        Intent intent = new Intent(MainActivity.this, Game.class);
        intent.putExtra("name", name);
        intent.putExtra("set", enable_song);
        intent.putExtra("number", id_class);
        startActivityForResult(intent, 1);
    }

    //menu
    public void play(View view) {
        click_sound();
        setContentView(R.layout.select_name);
        button_off();
    }

    public void load(View view){
        click_sound();
        id_class = 9;
        name = "default";
        start_game();
    }

    public void help(View view) {
        click_sound();
        setContentView(R.layout.help);
        button_off();
        TextView text_about = (TextView) findViewById(R.id.about_game);
        String text = "You are an adventure responsible by explore the dungeon seeking to eliminate a dungeon boss!\n\n" +
                "     How to play:\n" +
                "        You can choose from 5 classes, each with its own point distribution\n" +
                "        The level is unlimited, when you level up you'll receive an attribute point to distribute and 20% xp more is required to level up again\n" +
                "        The game automatically saves when you are out of combate\n"+
                "        You can not carry more than 4 potions.\n" +
                "        When you explore the dungeon, random events can occur, such as getting hurt in traps or encountering a random enemy!\n" +
                "        Enemies appear based on your level\n" +
                "        When you encounter an enemy, you can: fight, drink potions or try to escape.\n" +
                "        All actions have their own chance of failing. Drinking potions during combat, for example, is a little more dangerous than drinking out of combat!\n" +
                "        Storing potions can be a good idea, but you'll only find potions on exploration if don't have any.(you could be stolen too...)" +
                "        Low-level enemies are less dangerous, but give less experience, so think hard before defining your strategy!\n" +
                "        Good luck!";
        text_about.setText(text);
    }

    public void detalhes_help(View view) {
        click_sound();
        setContentView(R.layout.help);
        button_off();
        TextView text_about = (TextView) findViewById(R.id.about_game);
        String text = "@Atributos:\n Constitui????o: Determina a resist??ncia do personagem no geral\n   " +
            "aumenta moderadamente resistencia a todos os tipos de dano e bastante a sa??de m??xima\n" +
            "For??a: Determina a capacidade e efetividade do personagem para usar certos equipamentos \n   " +
            "aumenta o dano de armas baseadas em for??a e do personagem desarmado e um pouco a penetra????o na armadura, requisito pra armas e armaduras.\n" +
            "Destreza: Determina o qu??o habilidoso um personagem ?? com suas armas e ataques.\n    " +
            "aumenta moderadamente o dano de todas os ataques, inclusive a efetividade da armadura fornecida por escudos (requisitado em algumas armas).\n" +
            "Ast??cia: Determina a esperteza do personagem para coagir outros personagens e de encontrar pontos fracos e padr??es nos ataques inimigos.\n   " +
            "aumenta a chance de esquiva, cr??ticos e a persuas??o.\n" +
            "Magia: Determina a capacidade do personagem para manipular e usufruir de magia no geral.\n    " +
            "aumenta o dano  dos feiticos, melhora a efetividade de encantamentos em itens e de po????es.\n" +
            "Vitalidade: Determina a energia total do personagem em combate antes de sofrer exaust??o.\n     " +
            "aumenta a quantidade de ataques poss??veis reduzindo a velocidade da fadiga e um pouco a sa??de m??xima.\n" +
            "Sorte: Determina a sorte no geral para encontrar objetos, persuadir e at?? se sair bem em combates.     " +
            "aumenta a probabilidade de encontrar itens mais raros, aumenta a persuasao, aumenta um pouco a chance de cr??ticos e de esquiva\n\n"+
            "@Status:\n" +
            "HP: Pontos de vida do personagem\n" +
            "Energia: N??mero de ataques poss??veis antes de entrar em estado de exaust??o\n" +
            "Dano: Dano total causado por ataque (j?? calculado velocidade do ataque)\n" +
            "Penetra????o na Armadura: Porcentagem que ignora a armadura do inimigo\n" +
            "Armadura: Porcentagem de reducao de dano fisico\n" +
            "Esquiva: Probabilidade de esquivar de ataques\n" +
            "Chance Critica: Probabiilidade de causar acerto cr??tico (causa dobro do dano)\n" +
            "Persuasao: Probabilidade de conseguir persuadir\n" +
            "Resis a fria: Porcentagem de reducao de dano por frio\n" +
            "Resis ao calor: Porcentagem de reducao de dano de calor\n" +
            "Resis ao veneno: Porcentagem de reducao de dano por veneno\n" +
            "Resis a eletricidade: Porcentagem de reducao de dano  eletrico\n" +
            "Dano por fria: Dano por frio m??ximo causado no ataque\n" +
            "Dano por calor: Dano por  calor m??ximo causado no ataque\n" +
            "Dano por veneno: Dano por veneno m??ximo causado no ataque\n" +
            "Dano eletrico: Dano eletrico m??ximo causado no ataque\n";
        text_about.setText(text);
    }

    public void exit(View view) {
        click_sound();
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
    //

    public void get_name(View view){
        click_sound();
        EditText nameinput = (EditText) findViewById(R.id.name);
        name = nameinput.getText().toString();
        setContentView(R.layout.class_choose);
        button_off();
    }

    //class
    public void warrior(View view) {
        click_sound();
        id_class = 1;
        start_game();
    }

    public void wizard(View view) {
        click_sound();
        id_class = 2;
        start_game();
    }

    public void rogue(View view) {
        click_sound();
        id_class = 3;
        start_game();
    }

    public void tank(View view) {
        click_sound();
        id_class = 4;
        start_game();
    }

    public void none(View view) {
        click_sound();
        id_class = 5;
        start_game();
    }

    public void back(View view) {
        click_sound();
        setContentView(R.layout.menu);
        button_off();
    }

    public void back_class(View view) {
        click_sound();
        setContentView(R.layout.class_choose);
        button_off();
    }

    public void class_help(View view) {
        click_sound();
        setContentView(R.layout.help_class);
        button_off();
        TextView text_about = (TextView) findViewById(R.id.help_class);
        String text = "Warrior:\n" +
                "constitution 13, strength = 16, dexterity = 13, cunning = 10, vitality = 12, magic = 10, lucky = 10\n" +
                "Wizard\n" +
                "constitution = 10, strength = 10, dexterity = 10, cunning = 11, vitality = 15, magic = 17, lucky = 11;\n" +
                "Rogue\n" +
                "constitution = 10, strength = 10, dexterity = 15, cunning = 14, vitality = 12, magic = 10, lucky = 13;\n" +
                "Tank\n" +
                "constitution = 17, strength = 14, dexterity = 12, cunning = 10, vitality = 10, magic = 10, lucky = 11;\n" +
                "None\n" +
                "constitution = 12, strength = 12, dexterity = 12, cunning = 12, vitality = 12, magic = 12, lucky = 12;\n";
        text_about.setText(text);
    }

    //music
    public  void play_song(View view){
        if(view != null){
            set_enable_song();
        }
        if(music == null){
            play_song_fun();
        }else{
            stop_song();
        }
    }

    private void play_song_fun() {
        music = MediaPlayer.create(this, R.raw.start);
        music.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stop_song();
            }
        });
        music.setLooping(true);
        music.start();
    }
    public  void stop_song(){
        if(music != null){
            music.release();
            music = null;
        }
    }

    public void click_sound(){
        if(enable_song) {
            final MediaPlayer mp = MediaPlayer.create(this, R.raw.click);
            mp.setVolume(0.2f, 0.2f);
            mp.start();
        }
    }

    private void set_enable_song(){
        if(enable_song == true){
            enable_song= false;
            button_off();
        }else{
            enable_song = true;
            Button b = findViewById(R.id.sound);
            b.setBackgroundResource(android.R.drawable.ic_lock_silent_mode_off);
        }
    }
    private void button_off(){
        if(enable_song == false){
            Button b = findViewById(R.id.sound);
            b.setBackgroundResource(android.R.drawable.ic_lock_silent_mode);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                enable_song = data.getBooleanExtra("result",false);
                button_off();
            }else{
                enable_song = true;
            }
        }
    }

    @Override
    protected void onStop(){
        super.onStop();
        stop_song();
    }
    @Override
    protected void onResume(){
        super.onResume();
        if(enable_song==true){
            play_song(null);
        }
    }


}