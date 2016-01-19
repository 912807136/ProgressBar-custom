package com.example.test46;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

public class CustomProgressBar extends View {
	private int progress;
	private int backgroundColor;
	private int progressColor;
	private int width;
	private int height;
	private Paint paint;
	private RectF bgRectF;
	private RectF progressRectF;
	private String text;  
	private int textColor;
	private int textSize;
	private int corner;
	private Rect bounds;

	public CustomProgressBar(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public void setProgress(int progress) {
		this.progress = progress;
		invalidate();
	}

	public void setBackgroundColor(int backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public void setProgressColor(int progressColor) {
		this.progressColor = progressColor;
	}

	public void setTextColor(int textColor) {
		this.textColor = textColor;
	}

	public void setText(String text) {
		this.text = text;
		invalidate();
	}

	public void setTextSize(int textSize) {
		this.textSize = textSize;
	}

	public void setCorner(int corner) {
		this.corner = corner;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		if (width == 0) {
			width = getWidth();
			height = getHeight();
			paint = new Paint();
			paint.setAntiAlias(true);
			bgRectF = new RectF(0, 0, width, height);
			progressRectF = new RectF(0, 0, 0, height);
			bounds = new Rect();
		}
		// 绘制背景
		paint.setColor(backgroundColor);
		canvas.drawRoundRect(bgRectF, corner, corner, paint);

		// 绘制进度
		paint.setColor(progressColor);
		int Progresswidth = (int) (progress / 100f * width + 0.5);
		progressRectF.right = Progresswidth;
		canvas.drawRoundRect(progressRectF, corner, corner, paint);

		// 绘制文字
		if (!TextUtils.isEmpty(text)) {
			paint.setColor(textColor);
			paint.setTextSize(textSize);
			paint.getTextBounds(text, 0, text.length(), bounds);
			int baseline = height / 2 + (bounds.bottom - bounds.top) / 2;
			int left = (int) (width / 2 - paint.measureText(text) / 2);
			canvas.drawText(text, left, baseline, paint);
		}

	}

}
