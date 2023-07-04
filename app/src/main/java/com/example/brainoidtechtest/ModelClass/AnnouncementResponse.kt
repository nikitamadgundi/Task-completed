package com.example.brainoidtechtest.ModelClass
data class AnnouncementResponse(
    val status: Int,
    val message: String,
    val announcements: Announcement,
    val announcements_details: List<AnnouncementDetail>
)

data class Announcement(
    val id: Int,
    val title: String,
    val description: String,
    val image: String,
    val image_caption: String,
    val created_date: String,
    val last_updated: String,
    val status: String
)

data class AnnouncementDetail(
    val id: Int,
    val am_id: Int,
    val title: String,
    val title_date: String,
    val description: String,
    val push_notification: String,
    val text_link: String?,
    val image_link: String?,
    val audio_link: String?,
    val video_link: String?,
    val created_date: String,
    val last_updated: String,
    val status: String,
    val push_notification_subtitle: String,
    val live_schedule: String,
    val video_thumbnail: String?,
    val pn_status: Int,
    val pn_image_url: String?,
    val youtube_video_link: String?,
    val video_id: String?,
    val is_not_for_idea_selection: Int,
    val deleted_at: String?,
    val full_pn_image_url: String?
)
