package dp.aop;

import dp.proxy.Html;
import dp.proxy.IBrowser;

public class AopBrowser implements IBrowser {

    private String url;
    private Html html;
    private Runnable before;
    private Runnable after;

    public AopBrowser(String url, Runnable before, Runnable after) {
        this.url = url;
        this.before = before;
        this.after = after;
    }

    @Override
    public Html show() {

        before.run();

        if (html == null) {
            this.html = new Html(this.url);
            System.out.println("AopBrowser loading html from : " + url);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        after.run();

        System.out.println("AopBrowser cache html from : " + url);

        return html;
    }
}
