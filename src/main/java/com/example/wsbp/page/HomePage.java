package com.example.wsbp.page;

import com.example.wsbp.service.ISampleService;
import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

@WicketHomePage
@MountPath("Home")
public class HomePage extends WebPage {

    @SpringBean
    private ISampleService service;

    public HomePage() {

        var youModel = Model.of("Wicket-Spring-Boot");
        var youLabel = new Label("you", youModel);

        var youModel1 = Model.of("B2190350");
        var youLabel1 = new Label("gakuseki", youModel1);

        var timeModel = Model.of(service.makeCurrentHMS());
        var timeLabel = new Label("time", timeModel);

        var randomModel = Model.of(service.random());
        var randomLabel = new Label("random", randomModel);

        //ページ遷移
        var toUserMakerLink = new BookmarkablePageLink<>("toUserMaker", UserMakerPage.class);


        add(youLabel,youLabel1,timeLabel,randomLabel,toUserMakerLink);
    }

}