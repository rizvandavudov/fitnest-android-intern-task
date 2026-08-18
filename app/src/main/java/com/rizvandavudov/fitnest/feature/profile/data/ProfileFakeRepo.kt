package com.rizvandavudov.fitnest.feature.profile.data

import com.rizvandavudov.fitnest.R
import com.rizvandavudov.fitnest.core.ui.model.ThemedImageUiModel
import com.rizvandavudov.fitnest.feature.profile.ProfileTextsUiModel
import com.rizvandavudov.fitnest.feature.profile.SubscriptionStatus

class ProfileFakeRepo : ProfileDataSource {

    override val avatar: ThemedImageUiModel =
        ThemedImageUiModel(
            lightUrl = imageUrl(
                "profile_avatar_source.png",
            ),
            lightFallbackResId =
                R.drawable.profile_avatar_source,
        )

    override val userId: String = "12345ADFSG"

    override val firstName: String = "Leyla"

    override val lastName: String = "Abdullayeva"

    override val phoneNumber: String =
        "+994 50 650 45 45"

    override val email: String = "leyla@gmail.com"

    override val subscriptionTitle: String =
        "Premium Plan"

    override val subscriptionStatus: SubscriptionStatus =
        SubscriptionStatus.ACTIVE

    override val texts: ProfileTextsUiModel =
        ProfileTextsUiModel(
            title = "Profil",
            backContentDescription = "Geri qayıt",
            avatarContentDescription =
                "İstifadəçinin profil şəkli",
            avatarEditContentDescription =
                "Profil şəklini dəyiş",
            firstNameLabel = "Ad",
            lastNameLabel = "Soyad",
            phoneLabel = "Telefon nömrəsi",
            emailLabel = "E-mail",
            subscriptionLabel = "Abunəlik",
            userIconContentDescription = "İstifadəçi",
            phoneIconContentDescription = "Telefon",
            emailIconContentDescription = "E-mail",
            subscriptionIconContentDescription =
                "Abunəlik planı",
            editFirstNameContentDescription =
                "Adı redaktə et",
            editLastNameContentDescription =
                "Soyadı redaktə et",
            editPhoneContentDescription =
                "Telefon nömrəsini redaktə et",
            editEmailContentDescription =
                "E-mail ünvanını redaktə et",
            logoutTitle = "Çıxış",
            logoutDescription = "Hesabdan çıxış edin",
            logoutContentDescription =
                "Hesabdan çıxış et",
            saveButtonText = "Yadda saxla",
            saveContentDescription =
                "Profil məlumatlarını yadda saxla",
            subscriptionActiveLabel = "Aktiv",
            subscriptionInactiveLabel = "Deaktiv",
        )

    private fun imageUrl(
        fileName: String,
    ): String {
        return RAW_IMAGE_BASE_URL + fileName
    }

    private companion object {

        const val RAW_IMAGE_BASE_URL =
            "https://raw.githubusercontent.com/rizvandavudov/" +
                    "fitnest-android-intern-task/main/" +
                    "app/src/main/res/drawable-nodpi/"
    }
}