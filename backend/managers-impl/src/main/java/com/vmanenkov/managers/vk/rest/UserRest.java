package com.vmanenkov.managers.vk.rest;

import com.vmanenkov.managers.SocialNetworkInfo;

import java.util.List;

public class UserRest implements SocialNetworkInfo {
    Long id;
    String first_name;
    String last_name;
    String deactivated;
    Integer hidden;

    Long verified;
    Long blacklisted;
    Long sex;
    String bdate;
    String city;
    String country;
    String home_town;
    String photo_50;
    String photo_100;
    String photo_200_orig;
    String photo_200;
    String photo_400_orig;
    String photo_max;
    String photo_max_orig;
    Long online;
    String lists;
    String domain;
    Long has_mobile;
    String mobile_phone; // похоже, что этого уже нет в api
    String home_phone;
    String site;
    Long university;
    String university_name;
    Long faculty;
    String faculty_name;
    String graduation;
    List<UniversityRest> universities;
    List<SchoolRest> schools;
    String status;
    LastSeenRest last_seen;
    Long followers_count;
    Long common_count;
    CountersRest counters;
    OccupationRest occupation;
    String nickname;
    List<RelativeRest> relatives;
    Long relation;
    PersonalRest personal;

    // connections
    String skype;
    String facebook;
    String twitter;
    String livejournal;
    String instagram;

    // TODO: exports

    Long wall_comments;
    String activities;
    String interests;
    String music;
    String movies;
    String tv;
    String books;
    String games;
    String about;
    String quotes;
    Long can_post;
    Long can_see_all_posts;
    Long can_see_audio;
    Long can_write_private_message;
    Long timezone;
    String screen_name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getDeactivated() {
        return deactivated;
    }

    public void setDeactivated(String deactivated) {
        this.deactivated = deactivated;
    }

    public Integer getHidden() {
        return hidden;
    }

    public void setHidden(Integer hidden) {
        this.hidden = hidden;
    }

    public Long getVerified() {
        return verified;
    }

    public void setVerified(Long verified) {
        this.verified = verified;
    }

    public Long getBlacklisted() {
        return blacklisted;
    }

    public void setBlacklisted(Long blacklisted) {
        this.blacklisted = blacklisted;
    }

    public Long getSex() {
        return sex;
    }

    public void setSex(Long sex) {
        this.sex = sex;
    }

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHomeTown() {
        return home_town;
    }

    public void setHomeTown(String home_town) {
        this.home_town = home_town;
    }

    public String getPhoto50() {
        return photo_50;
    }

    public void setPhoto50(String photo_50) {
        this.photo_50 = photo_50;
    }

    public String getPhoto100() {
        return photo_100;
    }

    public void setPhoto100(String photo_100) {
        this.photo_100 = photo_100;
    }

    public String getPhoto200Orig() {
        return photo_200_orig;
    }

    public void setPhoto200Orig(String photo_200_orig) {
        this.photo_200_orig = photo_200_orig;
    }

    public String getPhoto200() {
        return photo_200;
    }

    public void setPhoto200(String photo_200) {
        this.photo_200 = photo_200;
    }

    public String getPhoto400Orig() {
        return photo_400_orig;
    }

    public void setPhoto400Orig(String photo_400_orig) {
        this.photo_400_orig = photo_400_orig;
    }

    public String getPhotoMax() {
        return photo_max;
    }

    public void setPhotoMax(String photo_max) {
        this.photo_max = photo_max;
    }

    public String getPhotoMaxOrig() {
        return photo_max_orig;
    }

    public void setPhotoMaxOrig(String photo_max_orig) {
        this.photo_max_orig = photo_max_orig;
    }

    public Long getOnline() {
        return online;
    }

    public void setOnline(Long online) {
        this.online = online;
    }

    public String getLists() {
        return lists;
    }

    public void setLists(String lists) {
        this.lists = lists;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Long getHasMobile() {
        return has_mobile;
    }

    public void setHasMobile(Long has_mobile) {
        this.has_mobile = has_mobile;
    }

    public String getMobilePhone() {
        return mobile_phone;
    }

    public void setMobilePhone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getHomePhone() {
        return home_phone;
    }

    public void setHomePhone(String home_phone) {
        this.home_phone = home_phone;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getGraduation() {
        return graduation;
    }

    public void setGraduation(String graduation) {
        this.graduation = graduation;
    }

    public String getFacultyName() {
        return faculty_name;
    }

    public void setFacultyName(String faculty_name) {
        this.faculty_name = faculty_name;
    }

    public Long getFaculty() {
        return faculty;
    }

    public void setFaculty(Long faculty) {
        this.faculty = faculty;
    }

    public String getUniversityName() {
        return university_name;
    }

    public void setUniversityName(String university_name) {
        this.university_name = university_name;
    }

    public Long getUniversity() {
        return university;
    }

    public void setUniversity(Long university) {
        this.university = university;
    }

    public List<UniversityRest> getUniversities() {
        return universities;
    }

    public void setUniversities(List<UniversityRest> universities) {
        this.universities = universities;
    }

    public List<SchoolRest> getSchools() {
        return schools;
    }

    public void setSchools(List<SchoolRest> schools) {
        this.schools = schools;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LastSeenRest getLastSeen() {
        return last_seen;
    }

    public void setLastSeen(LastSeenRest last_seen) {
        this.last_seen = last_seen;
    }

    public Long getFollowersCount() {
        return followers_count;
    }

    public void setFollowersCount(Long followers_count) {
        this.followers_count = followers_count;
    }

    public Long getCommonCount() {
        return common_count;
    }

    public void setCommonCount(Long common_count) {
        this.common_count = common_count;
    }

    public CountersRest getCounters() {
        return counters;
    }

    public void setCounters(CountersRest counters) {
        this.counters = counters;
    }

    public OccupationRest getOccupation() {
        return occupation;
    }

    public void setOccupation(OccupationRest occupation) {
        this.occupation = occupation;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<RelativeRest> getRelatives() {
        return relatives;
    }

    public void setRelatives(List<RelativeRest> relatives) {
        this.relatives = relatives;
    }

    public Long getRelation() {
        return relation;
    }

    public void setRelation(Long relation) {
        this.relation = relation;
    }

    public PersonalRest getPersonal() {
        return personal;
    }

    public void setPersonal(PersonalRest personal) {
        this.personal = personal;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getLivejournal() {
        return livejournal;
    }

    public void setLivejournal(String livejournal) {
        this.livejournal = livejournal;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    // TODO: exports setters and gettters


    public String getScreenName() {
        return screen_name;
    }

    public void setScreenName(String screen_name) {
        this.screen_name = screen_name;
    }

    public Long getTimezone() {
        return timezone;
    }

    public void setTimezone(Long timezone) {
        this.timezone = timezone;
    }

    public Long getCanWritePrivateMessage() {
        return can_write_private_message;
    }

    public void setCanWritePrivateMessage(Long can_write_private_message) {
        this.can_write_private_message = can_write_private_message;
    }

    public Long getCanSeeAudio() {
        return can_see_audio;
    }

    public void setCanSeeAudio(Long can_see_audio) {
        this.can_see_audio = can_see_audio;
    }

    public Long getCanSeeAllPosts() {
        return can_see_all_posts;
    }

    public void setCanSeeAllPosts(Long can_see_all_posts) {
        this.can_see_all_posts = can_see_all_posts;
    }

    public Long getCanPost() {
        return can_post;
    }

    public void setCanPost(Long can_post) {
        this.can_post = can_post;
    }

    public String getQuotes() {
        return quotes;
    }

    public void setQuotes(String quotes) {
        this.quotes = quotes;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getGames() {
        return games;
    }

    public void setGames(String games) {
        this.games = games;
    }

    public String getBooks() {
        return books;
    }

    public void setBooks(String books) {
        this.books = books;
    }

    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    public String getMovies() {
        return movies;
    }

    public void setMovies(String movies) {
        this.movies = movies;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getActivities() {
        return activities;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }

    public Long getWallComments() {
        return wall_comments;
    }

    public void setWallComments(Long wall_comments) {
        this.wall_comments = wall_comments;
    }
}
