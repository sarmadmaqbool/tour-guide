package com.sajjadafridi58.navigationappca;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.memetix.mst.detect.Detect;
import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;

import java.util.ArrayList;
import java.util.Locale;

public class SpeakTranslatorClass extends Fragment
{
    ImageView block, recorder;
    Button Ok, cancel;
    AlertDialog dialog;

    protected static final int RESULT_SPEECH = 1;
    private ImageButton btnSpeak;
    Language[] languages = Language.values();
    private TextToSpeech ttp;
    Spinner spTransLang, spSpeechedLang;
    ImageView speakEntered, speakTranslated;
    TextView textEntered, textTranslated;
    Button share, send;
    ProgressDialog progress;
    //.............

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.speaking_translation, container, false);
        //....................................

        ///.......................................
        ttp = new TextToSpeech(getActivity().getApplicationContext(),
                new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status != TextToSpeech.ERROR) {
                            ttp.setLanguage(Locale.UK);
                        }
                    }
                });
        progress = new ProgressDialog(getActivity());
        //...................................


        textEntered = (TextView) rootView.findViewById(R.id.audio);
        btnSpeak = (ImageButton) rootView.findViewById(R.id.mic);

        spTransLang = (Spinner) rootView.findViewById(R.id.stt_sp);
        spTransLang.setAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_dropdown_item, GetAllValues()));
        spTransLang.setSelection(1);
        spSpeechedLang = (Spinner) rootView.findViewById(R.id.spr_sst_src);
        spSpeechedLang.setAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_dropdown_item, GetAllValues()));
        spSpeechedLang.setSelection(9);
        share = (Button) rootView.findViewById(R.id.handshare);
        send = (Button)rootView. findViewById(R.id.sstIvSend);
        speakEntered = (ImageView)rootView. findViewById(R.id.sstspk);
        speakTranslated = (ImageView)rootView. findViewById(R.id.src_spkhand);

        textTranslated = (TextView)rootView. findViewById(R.id.hand_desc);

        //.................................................

        //Locale loc = new Locale("en");
        btnSpeak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //.............................
                //...........................................
                Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                i.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say something");
                try {
                    startActivityForResult(i, RESULT_SPEECH);
                    textEntered.setText("");
                } catch (ActivityNotFoundException a) {
                    Toast t = Toast.makeText(getActivity().getApplicationContext(),
                            "Ops! Your device doesn't support Speech to Text",
                            Toast.LENGTH_SHORT);
                    t.show();
                }
            }
        });

        //..............................................
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "" + textEntered.getText().toString() + " " + textTranslated.getText().toString();
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Translation");
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivityForResult(Intent.createChooser(sharingIntent, "Share via"), 0);
            }
        });

        speakEntered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpeakText(textEntered.getText().toString());
            }
        });

        speakTranslated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpeakText(textTranslated.getText().toString());
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                class bgStuff extends AsyncTask<Void, Void, Void> {
                    String translatedText = "";

                    @Override
                    protected void onPreExecute() {
                        progress.setTitle("Please wait");
                        progress.setMessage("Translating...");
                        progress.setIndeterminate(true);
                        progress.show();
                        super.onPreExecute();
                    }

                    @Override
                    protected Void doInBackground(Void... params) {
                        try {
                            translatedText = translation();
                        } catch (Exception e) {
                            translatedText = "Uable "+e.toString();
                        }
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void result) {
                        textEntered.setText(textEntered.getText().toString());
                        textTranslated.setText(translatedText);
                        progress.dismiss();
                        super.onPostExecute(result);
                    }

                }

                new bgStuff().execute();
            }
        });
        return rootView;
    }

    String detectedLanguage = "";

    public String translation() throws Exception {
        Translate.setClientId("Tourist_Guide");
        Translate.setClientSecret("PD59TUOBCRTDJWpPVsxCEgTCgg+oeYrPPyPWi4fohxA=");
        String translatedText = Translate.execute(textEntered.getText().toString(),
                Language.AUTO_DETECT, languages[spTransLang.getSelectedItemPosition()]);



        Language detectedLanguage = Detect.execute(textEntered.getText().toString());
        this.detectedLanguage = detectedLanguage.getName(Language.ENGLISH);
        Log.i("Translated text here", translatedText);

        return translatedText;
    }

    public String[] GetAllValues() {
        String lan[] = new String[languages.length];
        for (int i = 0; i < languages.length; i++) {
            lan[i] = languages[i].name();
        }
        return lan;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case RESULT_SPEECH: {
                if (resultCode == getActivity().RESULT_OK && null != data) {

                    ArrayList<String> text = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    textEntered.setText(text.get(0));
                }
                break;
            }

        }
    }

    public void SpeakText(String text) {
        ttp.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }


}
