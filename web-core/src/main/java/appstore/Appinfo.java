package appstore;

import org.springframework.data.annotation.Id;

public class Appinfo {
			
	@Id
	private String id;
	
	private String intro;
	private int score;
	private String top5App;
	private String appid;
	private String url;
	private String title;
	private String thumbnail_url;
	private String developer;
	
	public Appinfo() {
	}

	public Appinfo(String intro, int score, String relatedApps, String appid, String url, String title,
			String thumbnail_url, String developer) {
		super();
		this.intro = intro;
		this.score = score;
		this.top5App = relatedApps;
		this.appid = appid;
		this.url = url;
		this.title = title;
		this.thumbnail_url = thumbnail_url;
		this.developer = developer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getTop5App() {
		return top5App;
	}

	public void setTop5App(String relatedApps) {
		this.top5App = relatedApps;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumbnail_url() {
		return thumbnail_url;
	}

	public void setThumbnail_url(String thumbnail_url) {
		this.thumbnail_url = thumbnail_url;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	
	@Override
	public String toString() {
		return getUrl();
	}


}
