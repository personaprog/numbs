package br.com.persprog.appnumero.pkview;
/**
 * Created by persprog on 19/02/17.
 */
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;

import br.com.personaprog.playpputils.PlayEntity;
import br.com.personaprog.playpputils.PlayImage;
import br.com.personaprog.playpputils.PlayImageFactory;
import br.com.personaprog.playpputils.PlayRenderer;
import br.com.personaprog.playpputils.PlayView;
import br.com.personaprog.playpputils.model.JogoModel;
public class PlayBase extends PlayView {
  private boolean debug =true;
  private JogoModel model;
  private Rect tempRect = new Rect();
  private PlayImage playerImg;
  private PlayImage blocoImg;

  public PlayBase(Context context,JogoModel model) {
    super(context);
    this.model = model;
  }
  public PlayBase(Context context) {
    super(context);
  }
  @Override
  public void step(Canvas canvas) {
    model.step();
    PlayRenderer renderer = getRenderer();
    renderer.iniDraw(canvas, Color.WHITE);
    PlayEntity bloco ;
/*    if (debug == true) {*/
      PlayEntity player = model.getPlayer();
      renderer.drawRect(player.getPos(),player.getDim(),player.getDebugCor());
      int i =0;
   /*   while(true) {
        bloco = model.getBloco(i++);
        renderer.drawRect(bloco.getPos(), bloco.getDim(), bloco.getDebugCor());
      }*/
   /* }else {
      PlayEntity player = model.getPlayer();
      tempRect.set(0, 0, JogoModel.PLAYER_W, JogoModel.PLAYER_H);
      renderer.drawImg(playerImg,tempRect,player.getPos(),player.getDim());
      int i =0;
      tempRect.set(0, i * 100, JogoModel.PLAYER_W, JogoModel.PLAYER_H);
      while(true) {
        bloco = model.getBloco(i++);
        renderer.drawImg(blocoImg,tempRect,bloco.getPos(),bloco.getDim());
        if(i == 9){
          break;
        }
      }


    }*/
      renderer.fimImg();
    }
    @Override
    protected void setup() {
      model.setup();
    PlayImageFactory fac = getImgFac();
      playerImg = fac.createImage("meninas.png");
      blocoImg = fac.createImage("numbs.png");
  }
}