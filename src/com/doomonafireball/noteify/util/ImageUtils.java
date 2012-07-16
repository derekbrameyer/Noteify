package com.doomonafireball.noteify.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;

/**
 * User: derek Date: 7/15/12 Time: 9:06 AM
 */
public class ImageUtils {

    public static Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            // Case where we already have the bitmap!
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (drawable instanceof PictureDrawable) {
            // Case where we already have the picture!
            Bitmap bmp = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bmp);
            canvas.drawPicture(((PictureDrawable) drawable).getPicture());
            return bmp;
        }

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    public static Drawable bitmapToDrawable(Context ctx, Bitmap bitmap) {
        return new BitmapDrawable(ctx.getResources(), bitmap);
    }

}
