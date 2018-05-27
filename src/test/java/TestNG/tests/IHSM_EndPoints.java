package TestNG.tests;

public interface IHSM_EndPoints {

	
	//Timeslots - Contains all requests related to Event Timeslots
	//?eventId={eventId}&sessionTypeId={sessionTypeId}&day={day}&sessionId={sessionId}
	String GET_Agenda_Timeslot_SessionInfo = "api/timeslots/sessions";
	String GET_Agenda_TimeSlot_SessionInfo_ByTimeSlotID = "api/timeslots/sessions/{timeSlotid}";
	String POST_Add_Session_ToTimeslot = "api/timeslots/sessions?timeslotId={timeslotId}&sessionId={sessionId}";
	String PUT_Update_TimeSlotSession = "api/timeslots/sessions";
	String DELETE_TimeSlotSession = "api/timeslots/sessions/{TimeSlotSessionid}";
	String PUT_ReOrder_TimeSlot_Sessions = "api/timeslots/sessions/order";
	String PUT_UpdateSessionReference = " api/timeslots/sessions/etouches?timeslotSessionId={timeslotSessionId}&sessionRefId={sessionRefId}";
	String Get_Lean_ListOfTimeSlots_ByDay = "api/timeslots/lean?eventId={eventId}&day={day}";
	String Get_ListofTimeSlots_ByDay = "api/Timeslots?eventId={eventId}&day={day}";
	String Get_TimeSlot_ById = "api/Timeslots/{TimeSlotid}";
	String POST_Add_TimeSlot = "api/Timeslots";
	String PUT_Update_TimeSlot = "api/Timeslots";
	String DELETE_TimeSlot = "api/Timeslots/{TimeSlotid}";
	
	//Sessions - Contains all requests related to Sessions
	String PUT_Update_HyperLink_BySessionID = "api/sessions/hyperlinks";
	String GET_Speakers_AssociatedWith_Session = "api/sessions/speakers?sessionId={sessionId}";
	String POST_AddEventSpeaker_To_Session = "api/sessions/speakers?eventSpeakerId={eventSpeakerId}&sessionId={sessionId}&roleId={roleId}";
	String PUT_UpdateSessionSpeakers = "api/sessions/speakers";
	String DELETE_RemoveSessionSpeaker = "api/sessions/speakers/{id}";
	String PUT_ReorderSessionSpeaker = "api/sessions/speakers/order";
	String POST_AddTaxonomy = "api/sessions/taxonomies";
	String DELETE_RemoveTaxonomy = "api/sessions/taxonomies/{Taxonomyid}";
	String GET_LeanList_of_Sessions = "api/sessions/lean?eventId={eventId}";
	String GET_SessionHyperlinks_BySessionID = "api/sessions/hyperlinks?sessionId={sessionId}";
	String POST_AddHyperlink_BySessionID = "api/sessions/hyperlinks";
	String DELETE_Hyperlink_BySessionID = "api/sessions/hyperlinks/{id}";
	String GET_List_of_Sessions = "api/Sessions?limit={limit}&offset={offset}&term={term}&orderBy={orderBy}";
	String GET_Session_ByID = "api/Sessions/{Sessionid}";
	String POST_AddSession = "api/Sessions";
	String PUT_UpdateSession = "api/Sessions";
	
	//Speakers - Contains all requests related to Speakers
	String PUT_Speaker_reOrder_OrdersPage = "api/speakers/order";
	String PUT_SpeakerReference = "api/speakers/etouches?eventSpeakerId={eventSpeakerId}&eventSpeakerRefId={eventSpeakerRefId}&speakerRefId={speakerRefId}";
	String POST_AddSpeakerContact = "api/speakers/contacts";
	String PUT_UpdateSpeakerContact = "api/speakers/contacts";
	String DELETE_RemoveSpeakerContact_ByContactID = "api/speakers/contacts/{id}";
	String GET_GetLeanListOfSpeaker = "api/speakers/lean?eventId={eventId}";
	String POST_AddTaxonomyValue_To_Speaker = "api/speakers/taxonomies";
	String DELETE_RemoveTaxonomyValue_From_Speaker = "api/speakers/taxonomies/{id}";
	String POST_UploadSpeakerImageToCDN = "api/speakers/images/{id}";
	String GET_DownloadSpeaker_toExcel = "api/speakers/download/{eventId}?columns={columns}&speakers={speakers}";
	String POST_UploadSpeakerFromExcel = "api/speakers/upload";
	String GET_GetListofSpeakers = "api/Speakers?limit={limit}&offset={offset}&term={term}&orderBy={orderBy}";
	String GET_GetSpeaker_BySpeakerID = "api/Speakers/{id}";
	String POST_AddNewSpeaker = "api/Speakers?eventId={eventId}";
	String PUT_UpdateSpeaker = "api/Speakers?speakers={speakers}&eventId={eventId}";
	
	//Conferences - Contains all requests related to Conference events
	String GET_ConferenceEvent = "api/conferences/events/{id}";
	String GET_ConferenceEvent_byMostRecentStartDate = "api/conferences/events?confId={confId}&limit={limit}";
	String POST_AddNewConferenceEvent = "api/conferences/events";
	String PUT_UpdateConferenceEvent = "api/conferences/events";
	String POST_ImportEvent = "api/conferences/events/import?eventId={eventId}&sourceId={sourceId}";
	String GET_AllConferences = "api/Conferences";
	String GET_Conference_ById = "api/Conferences/{id}";
	
	//Taxonomies
	String GET_Taxonomies = "api/taxonomies/types?eventId={eventId}";
	String GET_TaxonomyCategory = "api/Taxonomies?eventId={eventId}&category={category}";
}
