from django.test import TestCase
import datetime
from django.utils import timezone

from .models import Question

class QuestionFakeModelTests(TestCase):
    def test_is_published_recently_with_future_question(self):
        time = timezone.now() + datetime.timedelta(days=30)
        future_question = Question(pub_date=time)
        self.assertIs(future_question.was_published_recently(), False)
# Create your tests here.
