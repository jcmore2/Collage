package com.jcmore2.collage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;

/**
 * 
 * Collage View is the parent view of a collage items.
 * 
 * @author Juan Carlos Moreno (jcmore2@gmail.com)
 * 
 */
public class CollageView extends RelativeLayout {

	private Context mContext;

	private final String BG = "#FFD4B081";

	private int collageWidth;
	private int collageHeight;

	private List<CardView> listCards = new ArrayList<CardView>();
	private boolean isViewRefresh = false;
	private boolean isCollageFixed = false;

	private final Random random = new Random();

	public CollageView(Context context) {
		this(context, null);
		init(context);
	}

	public CollageView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
		init(context);
	}

	public CollageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}

	private void init(Context context) {
		mContext = context;
		this.setMotionEventSplittingEnabled(true);
		this.setBackgroundColor(Color.parseColor(BG));

	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

		collageWidth = MeasureSpec.getSize(widthMeasureSpec);

		collageHeight = MeasureSpec.getSize(heightMeasureSpec);

		refreshViews();

		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
	}

	/**
	 * Function use to add Cards to internal list
	 * 
	 * @param card
	 */
	private void addViewToList(CardView card) {
		listCards.add(card);
	}

	/**
	 * Function use to refresh Cards when Collage has measure
	 */
	private void refreshViews() {
		if (!listCards.isEmpty() && !isViewRefresh) {
			for (CardView cardView : listCards) {
				RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
						cardView.getDrawable().getIntrinsicWidth(), cardView
								.getDrawable().getIntrinsicHeight());
				int left = random.nextInt(collageWidth) - collageWidth / 4;
				int top = random.nextInt(collageHeight) - collageHeight / 4;
				params.leftMargin = left;
				params.topMargin = top;
				params.rightMargin = -left;
				params.bottomMargin = -top;

				if (isCollageFixed)
					cardView.setFixedItem();

				this.addView(cardView, params);

			}
			isViewRefresh = true;
		}
	}

	/**
	 * Methos use to set Collage fixed (Cards cant move)
	 * 
	 * @param fixedCollage
	 */
	public void setFixedCollage(boolean fixedCollage) {
		isCollageFixed = fixedCollage;
	}

	/**
	 * Add Card from Bitmap
	 * 
	 * @param bm
	 */
	public void addCard(Bitmap bm) {

		CardView card = new CardView(mContext);
		card.setImageBitmap(bm);
		addViewToList(card);
	}

	/**
	 * Add Card from Drawable
	 * 
	 * @param drawable
	 */
	public void addCard(Drawable drawable) {

		CardView card = new CardView(mContext);
		card.setImageDrawable(drawable);
		addViewToList(card);
	}

	/**
	 * Add Card from resources
	 * 
	 * @param resId
	 */
	public void addCard(int resId) {

		CardView card = new CardView(mContext);
		card.setImageResource(resId);
		addViewToList(card);
	}

	/**
	 * Create a Collage from list of Bitmaps
	 * 
	 * @param bmList
	 *            List of bitmaps
	 */
	public void createCollageBitmaps(List<Bitmap> bmList) {
		for (Bitmap bm : bmList) {
			addCard(bm);
		}
	}

	/**
	 * Create a Collage from list of Drawables
	 * 
	 * @param drawableList
	 *            List of Drawables
	 */
	public void createCollageDrawables(List<Drawable> drawableList) {
		for (Drawable drawable : drawableList) {
			addCard(drawable);
		}
	}

	/**
	 * Create a Collage from list of Resources
	 * 
	 * @param resIdList
	 *            List of resources
	 */
	public void createCollageResources(List<Integer> resIdList) {

		for (Integer res : resIdList) {
			addCard(res.intValue());
		}
	}
}