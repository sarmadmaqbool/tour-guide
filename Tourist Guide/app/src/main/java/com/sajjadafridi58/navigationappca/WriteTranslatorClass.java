package com.sajjadafridi58.navigationappca;

import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.memetix.mst.detect.Detect;
import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;

import java.util.ArrayList;
import java.util.Locale;

public class WriteTranslatorClass extends Fragment {


    public static ArrayList<ClipData.Item> dic = new ArrayList<ClipData.Item>();
    Language[] languages = Language.values();
    TextToSpeech ttp;
    Spinner spTransLang, spSpeechedLang;
    ImageView speakTranslated, speakEntered;
    TextView textTranslated;
    EditText userText;
    Button share, send;
    ProgressDialog progress;
    InputMethodManager imm;
    // .................

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {



        View rootView = inflater.inflate(R.layout.written_translation, container, false);



        // ..............

        imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        // .............
        ttp = new TextToSpeech(getActivity().getApplicationContext(),
                new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status == TextToSpeech.SUCCESS) {
                            ttp.setLanguage(Locale.UK);
                        } else {
                            Toast.makeText(getActivity().getApplicationContext(), "failed",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        // /...................................


        // /.......................................
        progress = new ProgressDialog(getActivity());
        spTransLang = (Spinner)rootView.findViewById(R.id.spr_transs_des);
        spSpeechedLang = (Spinner)rootView.findViewById(R.id.spr_trans_src);

        spSpeechedLang.setAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, GetAllValues()));
        spSpeechedLang.setSelection(9);
        spTransLang.setAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, GetAllValues()));
        spTransLang.setSelection(40);

        share = (Button)rootView.findViewById(R.id.trans_share);
        send = (Button)rootView.findViewById(R.id.trans_translate);
        speakEntered = (ImageView)rootView.findViewById(R.id.trans_srcspk);
        speakTranslated = (ImageView)rootView.findViewById(R.id.trans_desspk);

        textTranslated = (TextView)rootView.findViewById(R.id.trans_translated);
        userText = (EditText)rootView. findViewById(R.id.usertext);
        userText.clearFocus();
        // ..............................................

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(
                        Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "" + userText.getText().toString() + "   "
                        + textTranslated.getText().toString();
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT,
                        "Translation");
                sharingIntent.putExtra(Intent.EXTRA_TEXT,
                        shareBody);
                startActivityForResult(
                        Intent.createChooser(sharingIntent, "Share via"), 0);
            }
        });

        speakEntered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpeakText(userText.getText().toString());
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

                imm.hideSoftInputFromWindow(userText.getWindowToken(), 0);
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
                            translatedText = "";
                        }
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void result) {
                        progress.dismiss();
                        textTranslated.setText(translatedText);
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
        Translate.setClientId("Tourist_Guide");//register name
        Translate
                .setClientSecret("PD59TUOBCRTDJWpPVsxCEgTCgg+oeYrPPyPWi4fohxA=");// id
        String translatedText = Translate.execute(
                userText.getText().toString(), Language.AUTO_DETECT,
                languages[spTransLang.getSelectedItemPosition()]);

        Language detectedLanguage = Detect.execute(userText.getText()
                .toString());
        this.detectedLanguage = detectedLanguage.getName(Language.ENGLISH);

        return translatedText;
    }

    public String[] GetAllValues() {
        String lan[] = new String[languages.length];
        for (int i = 0; i < languages.length; i++) {
            lan[i] = languages[i].name();
        }
        return lan;
    }

    public void SpeakText(String text) {
        ttp.speak(text, TextToSpeech.QUEUE_FLUSH, null);

    }


}

