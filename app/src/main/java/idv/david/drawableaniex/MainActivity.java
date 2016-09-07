package idv.david.drawableaniex;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView ivDice;
    private TextView tvResult;
    private Button btnRollDice;
    private AnimationDrawable aniDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        ivDice = (ImageView) findViewById(R.id.ivDice);
        tvResult = (TextView) findViewById(R.id.tvResult);
        // 從程式資源中取得動畫檔，設定給ImageView物件
        aniDrawable = (AnimationDrawable) ContextCompat.getDrawable(this, R.drawable.anim_dice);

        btnRollDice = (Button) findViewById(R.id.btnRollDice);
        btnRollDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 檢查動畫是否正在播放
                if (!aniDrawable.isRunning()) {
                    ivDice.setImageDrawable(aniDrawable);
                    aniDrawable.start();
                    btnRollDice.setText("停止");
                } else {
                    aniDrawable.stop();
                    btnRollDice.setText("擲骰子");
                    int random = (int) (Math.random() * 6) + 1;
                    String result = getString(R.string.dice_result) + random;
                    tvResult.setText(result);
                    switch (random) {
                        case 1:
                            ivDice.setImageResource(R.drawable.dice01);
                            break;
                        case 2:
                            ivDice.setImageResource(R.drawable.dice02);
                            break;
                        case 3:
                            ivDice.setImageResource(R.drawable.dice03);
                            break;
                        case 4:
                            ivDice.setImageResource(R.drawable.dice04);
                            break;
                        case 5:
                            ivDice.setImageResource(R.drawable.dice05);
                            break;
                        case 6:
                            ivDice.setImageResource(R.drawable.dice06);
                            break;
                    }
                }
            }
        });

    }
}
