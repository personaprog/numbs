package br.com.persprog.appnumero;
import android.graphics.Point;
import android.os.Bundle;

import br.com.personaprog.playpputils.PlayActivity;
import br.com.personaprog.playpputils.model.JogoModel;
import br.com.persprog.appnumero.pkview.PlayBase;
import br.com.persprog.appnumero.pkview.QuantView;
public class NumeroActivity extends PlayActivity {
  public final static String TAG = "PerrsonaProg";
  private PlayBase pView;
  private JogoModel model;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Point point  = new Point(480,320);
    model = new JogoModel(point);
    pView =new PlayBase(this,model);
    enableFullScreen();
    enebleKeepScreenOn();
    setContentView(pView);
  }
}
