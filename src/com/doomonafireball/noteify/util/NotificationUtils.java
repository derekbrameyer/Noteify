package com.doomonafireball.noteify.util;

import com.doomonafireball.noteify.R;
import com.doomonafireball.noteify.activity.MainActivity;
import com.doomonafireball.noteify.model.Note;
import com.jakewharton.notificationcompat2.NotificationCompat2;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

/**
 * User: derek Date: 6/5/12 Time: 12:16 PM
 */
public class NotificationUtils {

    public static void createNotification(Context ctx, Note note) {
        NotificationManager mNM = (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
        /*SharedPrefsManager mSPM = SharedPrefsManager.getInstance(); */

        PreFroyoNotificationStyleDiscover pfnsd = new PreFroyoNotificationStyleDiscover(ctx);

        NotificationCompat2.Builder build = new NotificationCompat2.Builder(ctx)
                .setContentTitle(note.getTitle())
                .setContentText(note.getText())
                .setTicker(note.getText())
                .setSmallIcon(R.drawable.icon)
                .addAction(
                        android.R.drawable.ic_btn_speak_now,
                        "Speak!",
                        PendingIntent.getActivity(ctx, 0,
                                getIntent(ctx), 0))
                .addAction(
                        android.R.drawable.ic_dialog_map,
                        "Maps",
                        PendingIntent.getActivity(ctx, 0,
                                getIntent(ctx), 0))
                .addAction(
                        android.R.drawable.ic_dialog_info,
                        "Info",
                        PendingIntent.getActivity(ctx, 0,
                                getIntent(ctx), 0));

        Notification notification = new NotificationCompat2.BigTextStyle(build)
                .bigText(""
                        + "This is a very long piece of text. "
                        + "This is a very long piece of text. "
                        + "This is a very long piece of text. "
                        + "This is a very long piece of text. "
                        + "This is a very long piece of text. "
                        + "This is a very long piece of text. "
                        + "This is a very long piece of text. ")
                .build();

        Intent notificationIntent = new Intent(ctx, MainActivity.class);

        mNM.notify(1, notification);

        /*PendingIntent pi = PendingIntent.getActivity(ctx, 0, new Intent(), PendingIntent.FLAG_UPDATE_CURRENT);

        RemoteViews contentView = new RemoteViews(ctx.getPackageName(), R.layout.two_line_notif);
        contentView.setImageViewResource(R.id.image, R.drawable.icon_notif);
        contentView.setTextViewText(R.id.title, title);
        contentView.setTextViewText(R.id.text, text);
        contentView.setTextColor(R.id.title, pfnsd.getTitleColor());
        contentView.setTextColor(R.id.text, pfnsd.getTextColor());
        contentView.setFloat(R.id.title, "setTextSize", pfnsd.getTitleSize());
        contentView.setFloat(R.id.text, "setTextSize", pfnsd.getTextSize());

        Notification notif = new Notification(icon, ticker, when);
        //notif.setLatestEventInfo(ctx, title, text, pi);
        notif.contentView = contentView;
        notif.contentIntent = pi;
        notif.flags |= Notification.FLAG_AUTO_CANCEL;
        mNM.notify(1, notif);*/
    }

    private static Intent getIntent(Context ctx) {
        Intent i = new Intent(ctx, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        return i;
    }
}
