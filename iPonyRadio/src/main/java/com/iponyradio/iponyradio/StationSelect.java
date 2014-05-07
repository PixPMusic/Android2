package com.iponyradio.iponyradio;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageButton;

public class StationSelect extends ActionBarActivity {

    // Buttons
    private ImageButton alicornRadioBtn;
    private ImageButton bestPonyRadioBtn;
    private ImageButton bronyRadioBtn;
    private ImageButton celestiaRadioBtn;
    private ImageButton everfreeRadioBtn;
    private ImageButton everyPonyRadioBtn;
    private ImageButton fillydelphiaRadioBtn;
    private ImageButton fracturedFrequenciesBtn;
    private ImageButton lunaRadioBtn;
    private ImageButton pegabitSoundsBtn;
    private ImageButton ponyvillefmBtn;
    private ImageButton sonicRadioBoomBtn;
    private ImageButton theHiveRadioBtn;
    private ImageButton wonderboltRadioBtn;

    // 80Kbps http://96.47.231.100:8000/stream/3/
    // 128Kbps http://96.47.231.100:8000/stream/1/
    // 320Kbps http://96.47.231.100:8000/stream/2/
    public CharSequence everfreeRadio[] = new CharSequence[] {"80Kbps", "128Kbps", "320Kbps" };

    // 128Kbps http://molestia.celestiaradio.com:8062/stream
    public CharSequence celestiaradio[] = new CharSequence[] {"128Kbps"};

    //
    // public CharSequence ponyfeather[] = new CharSequence[] {"128Kbps"};

    // 64Kbps http://208.67.6.112:8004/
    // 128Kbps http://listen.fillyradio.com:8000/
    // 320Kbps http://208.67.6.112:9998/
    public CharSequence fillydelphiaRadio[] = new CharSequence[] {"64Kbps", "128Kbps", "320Kbps" };

    // 64Kbps http://198.211.99.242:8014/stream2
    // 128Kbps http://198.211.99.242:8014/stream
    public CharSequence ponyvillefm[] = new CharSequence[] {"64Kbps", "128Kbps"};

    // 64Kbps http://198.211.99.242:8002/maac
    // 128Kbps http://198.211.99.242:8002/stream
    public CharSequence lunaRadio[] = new CharSequence[] {"64Kbps", "128Kbps"};

    // 128Kbps http://198.211.99.242:8008/stream
    public CharSequence alicornRadio[] = new CharSequence[] {"128Kbps"};

    // 128Kbps http://198.211.99.242:8020/stream
    public CharSequence sonicRadioBoom[] = new CharSequence[] {"128Kbps"};

    // 128Kbps http://198.211.99.242:8032/stream
    public CharSequence fracturedFrequencies[] = new CharSequence[] {"128Kbps"};

    // 128Kbps http://dj.bronyradio.com:8000
    public CharSequence bronyRadio[] = new CharSequence[] {"128Kbps"};

    // 128Kbps http://76.73.96.50:8071
    public CharSequence everyPonyRadio[] = new CharSequence[] {"128Kbps"};

    // 128Kbps http://198.211.99.242:8062/stream
    public CharSequence wonderboltRadio[] = new CharSequence[] {"128Kbps"};

    // 128Kbps http://198.211.99.242:8050/stream
    public CharSequence bestPonyRadio[] = new CharSequence[] {"128Kbps"};

    // 128Kbps http://198.211.99.242:8068/stream
    public CharSequence pegabitSounds[] = new CharSequence[] {"128Kbps"};

    // 128Kbps http://hiveradio.net:8000/
    public CharSequence theHiveRadio[] = new CharSequence[] {"128Kbps"};

    public void popupMaker(CharSequence array[]) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Pick Quality");
        builder.setItems(array, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // the user clicked on colors[which]
            }
        });
        builder.show();
    }


    public void onCreate(Bundle savedInstanceState) {
        /*setContentView(R.layout.fragment_station_select);

        //alicornRadioBtn = (ImageButton) findById(R.id.alicornRadio);
        bestPonyRadioBtn = (ImageButton) findViewById(R.id.bestPonyRadio);
        bronyRadioBtn = (ImageButton) findViewById(R.id.bronyRadio);
        celestiaRadioBtn = (ImageButton) findViewById(R.id.celestiaRadio);
        everfreeRadioBtn = (ImageButton) findViewById(R.id.everfreeRadio);
        // everyPonyRadioBtn = (ImageButton) findViewById(R.id.everyPonyRadio);
        fillydelphiaRadioBtn = (ImageButton) findViewById(R.id.fillydelphiaRadio);
        fracturedFrequenciesBtn = (ImageButton) findViewById(R.id.fracturedFrequencies);
        lunaRadioBtn = (ImageButton) findViewById(R.id.lunaRadio);
        pegabitSoundsBtn = (ImageButton) findViewById(R.id.pegabitSounds);
        ponyvillefmBtn = (ImageButton) findViewById(R.id.ponyvillefm);
        // sonicRadioBoomBtn = (ImageButton) findViewById(R.id.);
        theHiveRadioBtn = (ImageButton) findViewById(R.id.theHiveRadio);
        wonderboltRadioBtn = (ImageButton) findViewById(R.id.wonderboltRadio);
        */

        bronyRadioBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                popupMaker(bronyRadio);
            }
        });
    }
}
